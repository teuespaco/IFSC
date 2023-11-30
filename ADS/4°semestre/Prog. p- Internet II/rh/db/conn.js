const mysql = require('mysql')

const pool = mysql.createPool({
    connectionLimit: 10,
    host: 'localhost',
    user: 'ruan',
    password: 'binderruan',
    database: 'rh',
    port: 3306
})

module.exports = pool