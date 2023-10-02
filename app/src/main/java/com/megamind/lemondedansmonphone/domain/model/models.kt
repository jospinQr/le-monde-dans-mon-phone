package com.megamind.lemondedansmonphone.domain.model

data class Country(
    val name: Name,
    val tld: List<String>,
    val cca2: String,
    val ccn3: String,
    val cca3: String,
    val independent: Boolean,
    val status: String,
    val unMember: Boolean,
    val currencies: Map<String, Currency>,
    val idd: Idd,
    val capital: List<String>,
    val altSpellings: List<String>,
    val region: String,
    val subregion: String,
    val languages: Map<String, String>,
    val translations: Translations,
    val latlng: List<Double>,
    val landlocked: Boolean,
    val area: Double,
    val demonyms: Demonyms,
    val flag: String,
    val maps: Maps,
    val population: Int,
    val car: Car,
    val timezones: List<String>,
    val continents: List<String>,
    val flags: Flags,
    val coatOfArms: CoatOfArms,
    val startOfWeek: String,
    val capitalInfo: CapitalInfo,
    val postalCode: PostalCode
)

data class Name(
    val common: String,
    val official: String,
    val nativeName: Map<String, NativeName>
)

data class NativeName(
    val official: String,
    val common: String
)

data class Currency(
    val name: String,
    val symbol: String
)

data class Idd(
    val root: String,
    val suffixes: List<String>
)

data class Translations(
    val ara: Translation,
    val bre: Translation,
    val ces: Translation,
    val cym: Translation,
    val deu: Translation,
    val est: Translation,
    val fin: Translation,
    val fra: Translation,
    val hrv: Translation,
    val hun: Translation,
    val ita: Translation,
    val jpn: Translation,
    val kor: Translation,
    val nld: Translation,
    val per: Translation,
    val pol: Translation,
    val por: Translation,
    val rus: Translation,
    val slk: Translation,
    val spa: Translation,
    val srp: Translation,
    val swe: Translation,
    val tur: Translation,
    val urd: Translation,
    val zho: Translation
)

data class Translation(
    val official: String,
    val common: String
)

data class Demonyms(
    val eng: DemonymsEng,
    val fra: DemonymsFra
)

data class DemonymsEng(
    val f: String,
    val m: String
)

data class DemonymsFra(
    val f: String,
    val m: String
)

data class Maps(
    val googleMaps: String,
    val openStreetMaps: String
)

data class Car(
    val signs: List<String>,
    val side: String
)

data class Flags(
    val png: String,
    val svg: String
)

data class CoatOfArms(
    val png: String,
    val svg: String
)

data class CapitalInfo(
    val latlng: List<Double>
)

data class PostalCode(
    val format: String,
    val regex: String
)