package com.example.documentales.data

import com.example.documentales.R
import com.example.documentales.model.Documental

class DataSource() {
    fun loadAffirmations(): List<Documental> {
        return listOf<Documental>(
            Documental(R.string.documentales1, R.drawable.image1),
            Documental(R.string.documentales2, R.drawable.image2),
            Documental(R.string.documentales3, R.drawable.image3),
            Documental(R.string.documentales4, R.drawable.image4),
            Documental(R.string.documentales5, R.drawable.image5),
            Documental(R.string.documentales6, R.drawable.image6),
            Documental(R.string.documentales7, R.drawable.image7),
            Documental(R.string.documentales8, R.drawable.image8),
            Documental(R.string.documentales9, R.drawable.image9),
            Documental(R.string.documentales10, R.drawable.image10))
    }
}