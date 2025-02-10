const app = express();

app.use(express.json());
app.use(cors());
app.use(router);

export default app;
console.log('Hello World'); 