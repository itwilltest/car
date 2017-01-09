package net.member.action;

/*
 ActionForwardŬ������  Action�������̽����� ����� �����ϰ�....
 ������� ������ �������� ������(�̵�)�ҋ� ���Ǵ� Ŭ������.
 
 �ϴ���1. ������ �̵� ��� ���ΰ� ������  �������ִ� ����
               ������ �̵� ��� ���ΰ� true�϶� -> sendRedirect()���
               ������ �̵� ��� ���ΰ� false�϶� -> forward()���
 
 �ϴ���2. �̵� ������ ��� �� �����Ͽ� ���� ���ִ� ���� 
 		
 */
public class ActionForward {

	// ������ �̵���� ���� �� ���� ����
	private boolean isRedirect = false;
	// true sendRedirect() <-- �̹���� �̵��� ������ �ּ� ��� ������.
	// false forward() <-- �̹���� �̵��� ������ �ּ� ��� ���� ����.

	// �̵������� ��� �ּҰ� ���� ����
	private String path = null;

	// ������ �̵���� ���ΰ� ���� �޼ҵ�
	public boolean isRedirect() {
		return isRedirect;
	}

	// ������ �̵� ��� ���ΰ� ���� �޼ҵ�
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	// �̵������� ��� �ּҰ� ���� �޼ҵ�
	public String getPath() {
		return path;
	}

	// �̵��� ������ ��� �ּҰ� ���� �޼ҵ�
	public void setPath(String path) {
		this.path = path;
	}

}
