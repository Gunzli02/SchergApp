package com.example.schergapp.repository

import com.example.schergapp.model.IModel

interface IRepository {

    suspend fun getAll(): List<IModel>
    fun getByID(id: Int): IModel
    suspend fun delete(id: Int)
    fun update(model: IModel)
    fun create(model: IModel)

}