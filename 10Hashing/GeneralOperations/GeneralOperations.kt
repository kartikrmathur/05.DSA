package generaloperations

fun main() {
    accessingItems()
}

fun accessingItems() {
    val locationsMap = HashMap<String, String>()

    locationsMap["USA"] = "Washington D.C."     // idiomatic — instead of .put()
    locationsMap["India"] = "New Delhi"
    locationsMap["Nigeria"] = "Abuja"
    locationsMap["France"] = "Paris"

    val capital = locationsMap["USA"]
    println(capital)                            // Washington D.C.


    locationsMap.put("China", "Beijing")
    locationsMap["Germany"] = "Berlin"

    for((country, capital) in locationsMap) {
        println("$capital, $country")
    }

    val value = locationsMap.get("India")
    System.out.println(value)
    locationsMap.remove("France")
}