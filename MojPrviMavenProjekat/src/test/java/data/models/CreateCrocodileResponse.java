package data.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateCrocodileResponse implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    @SerializedName("age")
    @Expose
    private Integer age;
    private final static long serialVersionUID = 7838727261731306498L;

    public CreateCrocodileResponse() {
    }

    public CreateCrocodileResponse(Integer id, String name, String sex, String dateOfBirth, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
