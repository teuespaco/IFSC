const { DataTypes } = require('sequelize')

const db = require('../db/conn')

const Task = db.define('Task', {
    nome: {
        type: DataTypes.STRING,
        allowNull: false,
    },
    cidade: {
        type: DataTypes.STRING,
    },
    escolaridade: {
        type: DataTypes.STRING,
    },
    setor: {
        type: DataTypes.STRING,
    },
    idade: {
        type: DataTypes.STRING,
    },
    done: {
        type: DataTypes.BOOLEAN,
    }
})
module.exports = Task