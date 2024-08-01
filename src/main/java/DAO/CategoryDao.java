package DAO;

import Entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CategoryDao {
    private BDD bdd;

    public CategoryDao() {
        this.bdd = new BDD();
    }

    public ArrayList<Category> getAllCategories() throws SQLException {
        ResultSet rs = bdd.selectRequete("Select * from categories");
        ArrayList<Category> listCategories = new ArrayList<Category>();
        while (rs.next()) {
            listCategories.add(new Category(rs.getInt("category_id"), rs.getString("nom"), rs.getString("description")));
        }
        return listCategories;
    }

    public Category getCategory(int id) throws SQLException {
        ResultSet rs = bdd.selectRequete("Select category_id, nom, description from categories where category_id=" + id);
        if (rs.next()) {
            Category category = new Category(rs.getInt("category_id"), rs.getString("nom"), rs.getString("description"));
            return category;
        } else {
            return null;
        }
    }
    public Category createCategory(String nom, String description) throws Exception{
        ArrayList<Data> datas = new ArrayList<>();
        Data data1 = new Data(1,"string",nom);
        Data data2 = new Data(2,"string",description);
        datas.add(data1);
        datas.add(data2);
        bdd.crudRequete("INSERT INTO categories (nom,description) values(?,?)",datas);
        Category category = new Category(nom, description);
        return category;
    }

}


