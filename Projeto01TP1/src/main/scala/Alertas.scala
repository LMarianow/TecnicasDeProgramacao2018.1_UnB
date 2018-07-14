final case class InvalidArgument(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)
final case class InvalidMethod(private val message: String = "", private val cause: Throwable = None.orNull) extends Exception(message, cause)
