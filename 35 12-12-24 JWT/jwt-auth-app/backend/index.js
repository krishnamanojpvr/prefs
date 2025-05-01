const express = require('express');
const app = express();
const cors = require('cors');
const mongoose = require('mongoose');
const userRoutes = require('./routes/userroutes');
app.use(cors());
app.use(express.json());

mongoose.connect('mongodb://localhost:27017/jwt-auth-app')
    .then(() => {
        console.log('Connected to MongoDB');
    }
    )
    .catch((err) => {
        console.log(err);
    });

app.use('/auth', userRoutes);

app.listen(4000, () => {
    console.log('Server started on http://localhost:4000');
});