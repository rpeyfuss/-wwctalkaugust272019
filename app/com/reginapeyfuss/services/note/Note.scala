package com.reginapeyfuss.services.note

case class Note(name: String, duration: String, octave: Int)

//the following is the same as the case class Note
class NoteCls(_name: String, _duration: String, _octave: Int) extends Serializable {
    val name: String = _name
    val duration: String = _duration
    val octave: Int = _octave
    override def equals(other: Any) : Boolean = other match {
        case that: Note =>
            (that canEqual this) &&
                name == that.name && duration == that.duration &&
                octave == that.octave
        case _ => false
    }
    def canEqual(other: Any): Boolean = other.isInstanceOf[Note]

    override def hashCode(): Int = {
        val state = Seq(name, duration, octave)
        state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a +  b)
    }

    override def toString = s"Note($name, $duration, $octave)"

    def copy(name: String = name, duration: String = duration, octave: Int = octave): Note =
         Note(name, duration, octave)
}

object NoteCls {
    //omission of the `new` keyword
    def apply (name: String, duration: String, octave: Int): Note =
        Note(name, duration, octave)

    //Extractor for pattern matching
    def unapply (note: Note): Option[(String, String, Int)] =
        if (note eq null) None
        else Some((note.name, note.duration, note.octave))
}
