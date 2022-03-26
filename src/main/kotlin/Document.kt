class Document(
    override val type: String,
    val id: Int = 0,
    val userId: Int = 0
) : Attachment {
}