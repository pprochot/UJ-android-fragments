package com.github.pprochot.uj.android.fragments.models

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Order : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    var products: RealmList<Product> = RealmList()
    var customer: User? = null
    var date = Date()
    var cost: Money? = null
}