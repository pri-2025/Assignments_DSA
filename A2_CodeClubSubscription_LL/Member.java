package A2_CodeClubSubscription_LL;

public class Member {
	int m_id;
	String m_name;
	String pos;
	String acad_dets;

	Member next, prev;

	public Member(int id, String name, String position, String details) {
		this.m_id = id;
		this.m_name = name;
		this.pos = position;
		this.acad_dets = details;

		this.next = null;
		this.prev = null;
	}

}
