package com.example.commoncontextualmenu

data class Article(
    val id: Int,
    val title: String,
    val description: String,
    val featuredImage: Int
) {
    companion object {
        val data
            get() = listOf(
                Article(
                    1,
                    "10 Tips Para Estudiar",
                    "Descubre cómo aumentar tu productividad al estudiar",
                    R.drawable.learning1
                ),
                Article(
                    2,
                    "Guía para escribir tu primer cuento",
                    "Incursiona en el mundo de la narración infantil",
                    R.drawable.learning2
                ),
                Article(
                    3,
                    "Optimizar trabajos grupales",
                    "Aplica estas estrategias para mejorar tus trabajos en grupo",
                    R.drawable.learning3
                ),
                Article(
                    4,
                    "Libros que nunca habías escuchado",
                    "Te presentamos la lista de los libros más raros",
                    R.drawable.learning4
                ),
                Article(
                    5,
                    "Cómo mejorar en la universidad",
                    "En este artículo una actitud adecuada para la U",
                    R.drawable.learning5
                ),
                Article(
                    6,
                    "40 buscadores de artículos científicos",
                    "Descubre los buscadores más importantes para cada área del conocimiento",
                    R.drawable.learning6
                ),
                Article(
                    7,
                    "Pautas para escribir un ensayo",
                    "Karla te explica un marco de trabajo para hace ensayos",
                    R.drawable.learning7
                ),
                Article(
                    8,
                    "Crear un ambiente de estudio para llegar a \"la zona\"",
                    "Aprende a modificar tu entorno para sacar el máximo beneficio de tu mente",
                    R.drawable.learning8
                ),
                Article(
                    9,
                    "Estudiar 80 horas semanales",
                    "Como Carlos logró estudiar 80 horas sin agotarse",
                    R.drawable.learning9
                ),
                Article(
                    10,
                    "Lo que tu tutor de tesis no te dice",
                    "Consejos para terminar trabajos de grado rápido",
                    R.drawable.learning10
                )
            )
    }
}
