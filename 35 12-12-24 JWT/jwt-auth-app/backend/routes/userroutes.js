const router = require('express').Router()
const User = require('../models/user')
const bcrypt = require('bcrypt')
const jwt = require('jsonwebtoken')

router.post('/signup', async (req, res) => {
    const { name,email, password } = req.body;
    try{
        const checkEmail = await User.findOne({ email });
        if(checkEmail){
            return res.status(400).json({message: 'Email is already registered'});
        }
        const hashedPassword = await bcrypt.hash(password, 10);
        const user = new User({ email, name, password: hashedPassword });
        await user.save();
        res.status(201).json({message: 'User registered successfully'});
    }
    catch(err){
        res.status(500).json({message: 'Error registering user', error: err});
    }
}
);

router.post('/login', async (req, res) => {
    const { email, password } = req.body;
    try{
        const user = await User.findOne({ email });
        if(!user){
            return res.status(404).json({message: 'User not found'});
        }
        const match = await bcrypt.compare(password, user.password);
        if(!match){
            return res.status(401).json({message: 'Invalid password'});
        }
        const token = jwt.sign({ email : user.email, name : user.name, role : user.role},'secret',{expiresIn: '1h'});

        res.status(200).json({message: 'Login successful', token, user : {email : user.email, name : user.name, role : user.role}});
    }
    catch(err){
        res.status(500).json({message: "Error logging in.", error: err});
    }
});

module.exports = router;