import express from "express"
import cors from "cors";


// ROUTES
import userRoutes from './routes/user.js'
const app = express()
app.use(cors({
    origin: `http://${process.env.CLIENT_ADDRESS}:${process.env.CLIENT_PORT}`, 
    methods: ['GET','POST','DELETE','UPDATE','PUT','PATCH'],
    credentials: true,
    optionsSuccessStatus: 200 
}));
app.use(express.json())
app.use('/auth', userRoutes)

app.listen(3000, ()=>{
    console.log("SERVER IS RUNNING")
})