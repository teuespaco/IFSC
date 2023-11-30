//Instalar os módulos
//npm install nodemon express express-handlebars mysql

//Estrutura básica da aplicação
const express = require('express')
const exphbs = require('express-handlebars')
const pool = require('./db/conn')

const app = express()

app.engine('handlebars', exphbs.engine())
app.set('view engine', 'handlebars')

//midleware para interpretar os dados do formulário POST
app.use(
    express.urlencoded({
        extended: true
    })
)

app.use(express.json())

//midleware para definir a pasta estática 'pública'
app.use(express.static('public'))

//Rota inicial
app.get('/', function(req, res) {
    res.render('home')
})

//Rota para receber os dados do formulário cadastrar
app.post('/funcionarios/insertfuncionario', function(req, res) {
    const nome = req.body.nome
    const sobrenome = req.body.sobrenome
    const cidade = req.body.cidade
    const escolariade = req.body.escolariade
    const setor = req.body.setor
    const anonasc = req.body.anonasc
    const dataatual = new Date()

    const anoatual = dataatual.getFullYear();
    const idade = anoatual - anonasc;




    const sql = `INSERT INTO funcionarios (nome,sobrenome,cidade,escolariade,setor,anonasc,idade) VALUES ('${nome}','${sobrenome}','${cidade}','${escolariade}','${setor}',${anonasc}, ${idade});`

    pool.query(sql, function(err) {
        if (err) {
            console.log(err)
        }

        res.redirect('/')
    })
})

//Rota para listar todos os funcionarios
app.get('/funcionarios', function(req, res) {
    const sql = "SELECT * FROM funcionarios;"
    pool.query(sql, function(err, data) {
        if (err) {
            console.log(err)
        }

        res.render('funcionarios', { funcionarios: data })
    })
})

//Rota para listar o funcionario específico
app.get('/funcionarios/:id', function(req, res) {
    const id = req.params.id
    const sql = `SELECT * FROM funcionarios WHERE id = ${id}`
    pool.query(sql, function(err, data) {
        if (err) {
            console.log(err)
        }
        const funcionario = data[0]
        res.render('funcionario', { funcionario: funcionario })
    })
})

//Rota para editar o funcionario
app.get('/funcionarios/edit/:id', function(req, res) {
    const id = req.params.id
    const sql = `SELECT * FROM funcionarios WHERE id = ${id}`
    pool.query(sql, function(err, data) {
        if (err) {
            console.log(err)
        }
        const funcionario = data[0]

        res.render('editfuncionario', { funcionario: funcionario })
    })
})

//Rota para receber os dados atualizados do funcionario
app.post('/funcionarios/updatefuncionario', function(req, res) {
    const id = req.body.id
    const nome = req.body.nome
    const sobrenome = req.body.sobrenome
    const cidade = req.body.cidade
    const escolariade = req.body.escolariade
    const setor = req.body.setor
    const anonasc = req.body.anonasc
    const dataatual = new Date()

    const anoatual = dataatual.getFullYear();
    const idade = anoatual - anonasc;

    const sql = `UPDATE funcionarios SET nome='${nome}',sobrenome='${sobrenome}',escolariade='${escolariade}',setor='${setor}', cidade='${cidade}', idade=${idade} WHERE id = ${id}`
    pool.query(sql, function(err) {
        if (err) {
            console.log(err)
        }
        res.redirect(`/funcionarios/${id}`)
    })
})

//Rota para excluir o funcionario
app.post('/funcionarios/remove/:id', function(req, res) {
    const id = req.params.id
    const sql = `DELETE FROM funcionarios WHERE id = ${id}`
    pool.query(sql, function(err) {
        if (err) {
            console.log(err)
        }
        res.redirect(`/funcionarios`)
    })
})

app.listen(3000)