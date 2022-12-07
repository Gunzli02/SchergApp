package com.example.schergapp.repository

import com.example.schergapp.model.IModel

interface IRepository {

    suspend fun getAll(): List<IModel>
    suspend fun getByID(id: Int): IModel
    suspend fun delete(id: Int)
    suspend fun update(model: IModel)
    suspend fun create(model: IModel)

}