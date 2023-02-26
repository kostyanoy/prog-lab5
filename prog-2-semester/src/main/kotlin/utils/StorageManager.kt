package utils
import data.MusicBand
import data.MusicGenre
import java.time.LocalDateTime

class StorageManager(interactor: Interactor): Storage{
    private val date: LocalDateTime = LocalDateTime.now()
    val MusicBandCollection= LinkedHashMap<Int, MusicBand>()

    override fun getInfo() {
        println("Коллекция  ${this.javaClass} \nтип: LinkedHashMap количество элементов  ${MusicBandCollection.size} \nдата инициализации $date") }

    override fun show() {
        for (MusicBand in MusicBandCollection) {
            println(MusicBand.toString())}}

    override fun insertNull(id: Int, element: MusicBand){
        MusicBandCollection.put(id, element ) }

    override fun update(id: Int, element: MusicBand) {
        MusicBandCollection.set(id, element) }

    override fun remove(id:Int, element: MusicBand) {
        MusicBandCollection.remove(id, element)
    }


    override fun removeKey(id: Int) {
        MusicBandCollection.remove(id) }

    override fun clear() {
        MusicBandCollection.clear() }

    override fun getCollection(): LinkedHashMap<Int, MusicBand> {
        return MusicBandCollection }

    override fun countGreaterThanDesc(element: MusicBand): Int {
        var desCount = 0
        for(description in element.description){
            desCount+=1}
        return desCount }

    override fun filterLess(element: MusicBand): MusicGenre {
        return element.genre}
}


