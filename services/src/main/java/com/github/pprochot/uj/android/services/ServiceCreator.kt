package com.github.pprochot.uj.android.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class ServiceCreator {

    fun createUserService(serviceUrl: String) = createService<UserService>(serviceUrl)

    fun createCategoryService(serviceUrl: String) = createService<CategoryService>(serviceUrl)

    fun createProductService(serviceUrl: String) = createService<ProductService>(serviceUrl)

    fun createCartService(serviceUrl: String) = createService<CartService>(serviceUrl)

    fun createOrderService(serviceUrl: String) = createService<OrderService>(serviceUrl)

    private inline fun <reified T> createService(serviceUrl: String): T {
        val objectMapper = ObjectMapper().registerModule(KotlinModule()) //TODO replace and move to static
        val retrofit = Retrofit.Builder()
            .baseUrl(serviceUrl)
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build()
        return retrofit.create(T::class.java)
    }
}