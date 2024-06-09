package jp.co.withone.bookSearch.entity;

public class PublisherEntity {
//    出版社ID
    private String id;
//    出版社コード
    private String code;
//    出版社名
    private String name;
//    郵便番号
    private String zipCode;
//    住所
    private String address;

    
    
    
//    出版社ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
//    出版社コード
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
//    出版社名
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//    郵便番号
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
//    住所
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
