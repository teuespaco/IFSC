const bodyParser = require('body-parser');
const express = require('express');
const Router = express();

Router.get('/',(req,res)=>{
    res.send('oi');

});


