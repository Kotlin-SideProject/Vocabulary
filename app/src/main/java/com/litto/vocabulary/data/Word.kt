package com.litto.vocabulary.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = WordNames.TABLE_NAME)
data class Word(
    @PrimaryKey
    @ColumnInfo(name = WordNames.COL_NAME)
    val name: String,
    @ColumnInfo(name = WordNames.COL_MEANS)
    val means: String,
    @ColumnInfo(name = WordNames.COL_DIFFICULTY)
    val difficulty: Int,
    @ColumnInfo(name = WordNames.COL_STAR)
    val star : Int
) : Parcelable {
    @Ignore
    var id: Long? = null
}