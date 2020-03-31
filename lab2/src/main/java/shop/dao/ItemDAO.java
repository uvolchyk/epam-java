package shop.dao;/*
 * @project lab2
 * @author vladislav on 3/31/20
 */

import shop.entity.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class ItemDAO implements DAO<Item> {

    private final String path = "data/item.txt";
    private List<Item> cache;

    public ItemDAO() {
        this.cache = new ArrayList<>();
    }

    @Override
    public String path() {
        return path;
    }

    @Override
    public void read() {
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(path()));
            while((line = br.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(line, "_");
                while(stringTokenizer.hasMoreElements()) {
                    Integer count = Integer.parseInt(stringTokenizer.nextElement().toString());
                    Integer price = Integer.parseInt(stringTokenizer.nextElement().toString());
                    String name = stringTokenizer.nextElement().toString();
                    cache.add(new Item.Builder()
                                .withCount(count)
                                .withPrice(price)
                                .withName(name)
                                .build());
                }
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path()));
            StringJoiner result = new StringJoiner("_");
            getCache().forEach(e -> {
                result.add(e.getCount().toString())
                        .add(e.getPrice().toString())
                        .add(e.getName())
                        .add("\n");
            });
            bw.write(result.toString());
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Item older, Item newer) {
        Integer idx = cache.indexOf(older);
        cache.set(idx, newer);
    }

    @Override
    public void delete(Item obj) {
        cache.remove(obj);
    }

    @Override
    public List<Item> getCache() {
        return cache;
    }
}