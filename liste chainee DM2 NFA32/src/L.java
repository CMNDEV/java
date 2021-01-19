
public class L {
private Integer info;
private L suivant;

public L(Integer info, L suivant) {
	this.info = info;
	this.suivant = suivant;
}
public Integer getInfo() {
	return info;
}
public void setInfo(Integer myInfo) {
	this.info = myInfo;
}
public L getSuivant() {
	return suivant;
}
public void setSuivant(L mySuivant) {
	this.suivant = mySuivant;
}

}
