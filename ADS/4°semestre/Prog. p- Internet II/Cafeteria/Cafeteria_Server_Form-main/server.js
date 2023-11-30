const express = require('express');
const Router = express.Router();
const app = express();
const path = require('path');
const bodyParser = require('body-parser')

app.use(bodyParser.urlencoded({ extended: false }))
app.use(express.static(path.join(__dirname,'/cliente')));

app.post('/recebedados',(req,res)=>{
    res.send(`Os dados preenchidos foram: Nome: ${req.body.name} - E-mail: ${req.body.email} - Telefone: ${req.body.tel}`);
})

app.listen(5000,()=>{
    console.log('Server rodando na porta 5000')
})