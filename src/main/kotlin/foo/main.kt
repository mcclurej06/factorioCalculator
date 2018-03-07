package foo

fun main(args: Array<String>) {
//    val link = listOf(mineralizedWater, algaeFarm, liquifier, celluloseFibreToWoodPellets)
    val link = listOf(mudSource, mudToSoil, soilToTianaton, tianatonToCelluloseFibre, celluloseFibreToWoodPellets)
//    val link = listOf(mudToSoil, soilToTianaton)

    Chain(link).process()
}