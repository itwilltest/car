package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*Action ���� Ŭ��������....
 *Action�������̽��� �߻�޼ҵ带 �������̵� �����ν�  Ŭ���̾�Ʈ�� ��û ó�� ���¸� �԰�ȭ��Ŵ
 */
public interface Action { //ActionŬ�������� ����� ���� Ʋ
	
	//Ư�� Ŭ���̾�Ʈ�� ��û�� �����ϰ�  �װ�� ���� ActionForward��ü Ÿ������ ����
	//���� : �߻�޼ҵ� => ��ӹ��� Ŭ������ ������ �޼��� �������̵� �ؾ���
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception;

}











