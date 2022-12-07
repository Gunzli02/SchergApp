package com.example.schergapp.repository

import com.example.schergapp.model.IModel

interface IRepository {

    fun getAll(): List<IModel>
    fun getByID(id: Int): IModel
    fun delete(id: Int)
    fun update(model: IModel)
    fun create(model: IModel)

}