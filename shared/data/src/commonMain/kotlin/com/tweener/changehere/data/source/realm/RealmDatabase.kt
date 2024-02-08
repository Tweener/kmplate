package com.tweener.changehere.data.source.realm

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.UpdatePolicy
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.RealmUUID
import io.realm.kotlin.types.TypedRealmObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author Vivien Mahe
 * @since 08/02/2024
 */
class RealmDatabase {

    val realm: Realm by lazy {
        val configuration = RealmConfiguration.create(
            schema = setOf(
                // TODO Add here the Realm models, ie: RealmUserModel::class
            )
        )

        Realm.open(configuration)
    }

    inline fun <reified T : TypedRealmObject> getAll(): RealmResults<T> =
        realm.query<T>().find()

    inline fun <reified T : TypedRealmObject> getAllAsFlow(): Flow<RealmResults<T>> =
        realm.query<T>().asFlow().map { it.list }

    inline fun <reified T : TypedRealmObject> findByRealmUuid(uuid: String): T? =
        findByProperty(propertyName = "id", propertyValue = RealmUUID.from(uuid))

    inline fun <reified T : TypedRealmObject> findByProperty(propertyName: String, propertyValue: Any): T? =
        realm.query<T>("$propertyName == $0", propertyValue).first().find()

    inline fun <reified T : RealmObject> upsert(instance: T) =
        realm.writeBlocking {
            copyToRealm(instance, updatePolicy = UpdatePolicy.ALL)
        }

    inline fun <reified T : RealmObject> deleteById(id: String) {
        realm.writeBlocking {
            findByRealmUuid<T>(uuid = id)?.let { instance ->
                // To make sure to use the latest version of the frozen object, we need to use "findLatest"
                // See doc: https://www.mongodb.com/docs/realm/sdk/kotlin/realm-database/frozen-arch/#access-a-live-version-of-frozen-object
                findLatest(instance)?.also {
                    delete(it)
                }
            }
        }
    }
}
