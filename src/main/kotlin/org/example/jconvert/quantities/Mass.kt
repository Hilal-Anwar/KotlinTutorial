package org.example.jconvert.quantities

enum class Mass(val v: Double) {
    gram(1.0),
    tonne(1000000.0),
    long_ton(2240.0 * 450),
    short_ton(2000.0 * 450),
    long_hundredweight(51000.0),
    short_hundredweight(45000.0),
    long_quarter(28000.0),
    short_quarter(13000.0),
    stone(6400.0),
    pound(450.0),
    ounce(28.0),
    drachm(1.8),
    grain(0.065),
    troy_pound(370.0),
    troy_ounce(31.0),
    pennyweight(1.6),
    carat(0.2)

}
