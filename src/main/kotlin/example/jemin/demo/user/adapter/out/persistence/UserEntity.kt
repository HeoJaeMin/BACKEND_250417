package example.jemin.demo.user.adapter.out.persistence

import example.jemin.demo.config.jpa.TimeSuperclass
import example.jemin.demo.user.domain.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "\"user\"")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "email", nullable = false)
    val email: String,
    @Column(name = "phone", nullable = false)
    val phone: String,
    @Column(name = "address", nullable = true)
    val address: String?,
    @Column(name = "profile_picture_url", nullable = true)
    val profilePictureUrl: String?,
    @Column(name = "background_picture_url", nullable = true)
    val backgroundPictureUrl: String?,
) : TimeSuperclass() {
    constructor(user: User) : this(
        id = user.id,
        name = user.name,
        email = user.email,
        phone = user.phone,
        address = user.address,
        profilePictureUrl = user.profilePictureUrl,
        backgroundPictureUrl = user.backgroundPictureUrl,
    )

    fun toDomain() = User(
        id = id,
        name = name,
        email = email,
        phone = phone,
        address = address,
        profilePictureUrl = profilePictureUrl,
        backgroundPictureUrl = backgroundPictureUrl,
    )
}
