package db;

//��Ʈ�� ������ ���� ������ �����ϴ� ��Ŭ���� (DTO)
public class CarOrderBean {

	private int orderid; // �ڵ��� ��Ʈ(�뿩) �ֹ�id����
	// ��Ʈ�� ���� ����ȣ ���� : ����ȣ�� �����Ͽ� �˻��ϱ� ���Ͽ�
	private int carno;
	private int carqty;// ��Ʈ���� �뿩 ���� ����
	private int carreserveday;// �뿩�Ⱓ ����
	private String carbegindate;// �ڵ����� ��Ʈ(�뿩)�� ���۳�¥ ���� , �뿩��¥
	private int carins;// ��Ʈ�� �������� �ϼ� ����
	private int carwifi;// ��Ʈ�� ����wifi ���� �ϼ� ����
	private int carnave;// ��Ʈ�� �׺���̼� ���뿩�� ����(����� �����ϸ� 1, �������̸� 0)
	private int carbabyseat;// ��Ʈ�� ���̺� ��Ʈ ���� �ϼ� ����
	private String memberphone;// ��ȸ������ ��Ʈ�� ����� ����ȣ ����
	private String memberpass;// ��ȸ������ ��Ʈ�� �ֹ� �н����� ����

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCarno() {
		return carno;
	}

	public void setCarno(int carno) {
		this.carno = carno;
	}

	public int getCarqty() {
		return carqty;
	}

	public void setCarqty(int carqty) {
		this.carqty = carqty;
	}

	public int getCarreserveday() {
		return carreserveday;
	}

	public void setCarreserveday(int carreserveday) {
		this.carreserveday = carreserveday;
	}

	public String getCarbegindate() {
		return carbegindate;
	}

	public void setCarbegindate(String carbegindate) {
		this.carbegindate = carbegindate;
	}

	public int getCarins() {
		return carins;
	}

	public void setCarins(int carins) {
		this.carins = carins;
	}

	public int getCarwifi() {
		return carwifi;
	}

	public void setCarwifi(int carwifi) {
		this.carwifi = carwifi;
	}

	public int getCarnave() {
		return carnave;
	}

	public void setCarnave(int carnave) {
		this.carnave = carnave;
	}

	public int getCarbabyseat() {
		return carbabyseat;
	}

	public void setCarbabyseat(int carbabyseat) {
		this.carbabyseat = carbabyseat;
	}

	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}

	public String getMemberpass() {
		return memberpass;
	}

	public void setMemberpass(String memberpass) {
		this.memberpass = memberpass;
	}

}
