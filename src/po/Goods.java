package po;

import java.util.Arrays;

public class Goods {
	private int id;
	private String name;
	private String city;
	private int price;
	private int scoke;
	private byte images[];
	private String picname;
	
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	public Goods() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getScoke() {
		return scoke;
	}
	public void setScoke(int scoke) {
		this.scoke = scoke;
	}
	public byte[] getImages() {
		return images;
	}
	public void setImages(byte[] bs) {
		this.images = bs;
	}
	@Override
	public boolean equals(Object obj) {
		Goods goods=(Goods)obj;
		if(this.id == goods.id) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		// TODO 自动生成的方法存根
		if(this.name != null) {
			return name.hashCode();
		}
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", city=" + city + ", price=" + price + ", scoke=" + scoke
				+ ", images=" + Arrays.toString(images) + "]";
	}

	
}
