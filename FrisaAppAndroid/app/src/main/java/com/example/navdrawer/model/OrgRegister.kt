package com.example.navdrawer.model


class OrgRegister(
    val name: String,
    val phone: Int,
    val email: String,
    val street: String,
    val suburb: String,
    val city: String,
    val schedule: String,
    val linkWeb: String?,
    val linkFacebook: String?,
    val linkInstagram: String?,
    val linkTwitter: String?,
    val linkOther: String?,
    val description: String,
    val image: String,
    val tags: List<String>,
    val password: String,
    val posts: List<Post>
) {
    class Post(
        val title: String,
        val content: String,
        val image: String, // Puedes almacenar la URL de la imagen
        val date: String // Considera usar el tipo Date o LocalDateTime según tu necesidad
    )
}