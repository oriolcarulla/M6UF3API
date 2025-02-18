const express = require('express');
const mongoose = require('mongoose');
const app = express();
const port = process.env.PORT || 3030;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

mongoose.connect('mongodb+srv://oriolcarulla:6177@tasques.vpyz0.mongodb.net/Activitat3?retryWrites=true&w=majority&appName=Tasques', { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB'))
  .catch(err => console.log('Error connecting to MongoDB:', err));

const UserSchema = new mongoose.Schema({
  _id: String,
  nom_usuari: String,
  seguidors: Number,
  verificat: Boolean
});

const User = mongoose.model('User', UserSchema, 'Usuaris');

app.post('/users', async (req, res) => {
  if (!req.body.nom_usuari || !req.body._id) {
    req.body.nom_usuari = req.body.nom_usuari || "err";
    req.body._id = req.body._id || "err";
  }

  try {
    const user = new User({
      _id: req.body._id,
      nom_usuari: req.body.nom_usuari,
      seguidors: req.body.seguidors,
      verificat: req.body.verificat
    });
    await user.save();
    res.status(201).json(user);
  } catch (err) {
    res.status(400).json({ message: 'Error creating user', error: err.message });
  }
});

app.get('/users', async (req, res) => {
  try {
    const users = await User.find();
    res.status(200).json(users);
  } catch (err) {
    res.status(500).json({ message: 'Error fetching users', error: err.message });
  }
});

app.get('/users/:id', async (req, res) => {
  const { id } = req.params;
  try {
    const user = await User.findById(id);
    if (!user) {
      return res.status(404).json({ message: 'User not found' });
    }
    res.status(200).json(user);
  } catch (err) {
    res.status(500).json({ message: 'Error fetching user', error: err.message });
  }
});

app.put('/users/:id', async (req, res) => {
  const { id } = req.params;
  const { nom_usuari, seguidors, verificat } = req.body;
  try {
    const user = await User.findByIdAndUpdate(id, { nom_usuari, seguidors, verificat }, { new: true });
    if (!user) {
      return res.status(404).json({ message: 'User not found' });
    }
    res.status(200).json(user);
  } catch (err) {
    res.status(400).json({ message: 'Error updating user', error: err.message });
  }
});

app.delete('/users/:id', async (req, res) => {
  const { id } = req.params;
  try {
    const user = await User.findByIdAndDelete(id);
    if (!user) {
      return res.status(404).json({ message: 'User not found' });
    }
    res.status(200).json({ message: 'User deleted successfully' });
  } catch (err) {
    res.status(500).json({ message: 'Error deleting user', error: err.message });
  }
});
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`);
});