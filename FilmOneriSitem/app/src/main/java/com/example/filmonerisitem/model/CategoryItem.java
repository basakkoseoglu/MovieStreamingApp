package com.example.filmonerisitem.model;

// CategoryItem sınıfı, bir film kategorisine ait öğeleri temsil eder.
public class CategoryItem {

    private Integer id;           // Film öğesinin kimliğini tutan değişken
    private String movieName;     // Film öğesinin adını tutan değişken
    private String imageUrl;      // Film öğesinin resim URL'sini tutan değişken
    private String fileUrl;       // Film öğesinin dosya URL'sini tutan değişken

    // Yapıcı metot, bir CategoryItem nesnesi oluştururken gerekli parametreleri alır.
    public CategoryItem(Integer id, String movieName, String imageUrl, String fileUrl) {
        this.id = id;
        this.movieName = movieName;
        this.imageUrl = imageUrl;
        this.fileUrl = fileUrl;
    }

    // Film öğesinin kimliğini döndüren metot
    public Integer getId() {
        return id;
    }

    // Film öğesinin kimliğini set eden metot
    public void setId(Integer id) {
        this.id = id;
    }

    // Film öğesinin adını döndüren metot
    public String getMovieName() {
        return movieName;
    }

    // Film öğesinin adını set eden metot
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    // Film öğesinin resim URL'sini döndüren metot
    public String getImageUrl() {
        return imageUrl;
    }

    // Film öğesinin resim URL'sini set eden metot
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Film öğesinin dosya URL'sini döndüren metot
    public String getFileUrl() {
        return fileUrl;
    }

    // Film öğesinin dosya URL'sini set eden metot
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
