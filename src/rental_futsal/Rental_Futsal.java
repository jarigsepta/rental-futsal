package rental_futsal;

import java.util.Scanner;
public class Rental_Futsal {
	static String Jenis_Lapangan[];static String Nama[];static int No_Lapangan[];
	static int depan, belakang, jumlah, ukuran;
	static int t = 0;
	static Scanner in = new Scanner(System.in);
	
	Rental_Futsal() {
		Jenis_Lapangan = new String[0];
		Nama = new String[0];
		No_Lapangan = new int[0];ukuran = 2;
		jumlah = depan = belakang = 0;
	}
	
	public static void insert(int e,String d, String f) {
		int[] temp = new int[No_Lapangan.length];
		System.arraycopy(No_Lapangan,0,temp,0,No_Lapangan.length);
		String[] temp1 = new String[Nama.length];
		System.arraycopy(Nama,0,temp1,0,Nama.length);
		String[] temp2 = new String[Jenis_Lapangan.length];
		System.arraycopy(Jenis_Lapangan,0,temp2,0,Jenis_Lapangan.length);
		if (jumlah < ukuran) {
			No_Lapangan = new int[t+1];
			System.arraycopy(temp,0,No_Lapangan,0,temp.length);
			Nama = new String[t+1];
			System.arraycopy(temp1,0,Nama,0,temp1.length);
			Jenis_Lapangan = new String[t+1];
			System.arraycopy(temp2,0,Jenis_Lapangan,0,temp2.length);
			Jenis_Lapangan[belakang] = f;
			Nama[belakang] = d;
			No_Lapangan[belakang] = e;
			jumlah++;belakang++;ukuran++;t++;
		}
		//Source Code Buat Sorting No Lapangan
		int r = No_Lapangan.length;
		for (int i=1; i<r;i++) {
			for (int h=0; h<r-1;h++) {
				if (No_Lapangan[h+1]<No_Lapangan[h]) {
					int tmp=No_Lapangan[h+1];
					String tmp1=Nama[h+1];
					String tmp2=Jenis_Lapangan[h+1];
					No_Lapangan[h+1]=No_Lapangan[h];
					Nama[h+1]=Nama[h];
					Jenis_Lapangan[h+1]=Jenis_Lapangan[h];
					No_Lapangan[h]=tmp;
					Nama[h]=tmp1;
					Jenis_Lapangan[h]=tmp2;
				}
			}
		}
	}
	
	public static void remove() {
		if (jumlah == 0) {
			System.out.println("Lapangan Kosong");
		}
		for (int i = 0; i < jumlah-1;i++) {
			Jenis_Lapangan[i] = Jenis_Lapangan[i+1];
			Nama[i] = Nama[i+1];
			No_Lapangan[i] = No_Lapangan[i+1];
		}
		jumlah--; belakang--;ukuran--;
		System.out.println("Hapus Sukses");
	}
	
	public static void view() {
		System.out.print("Penyewa Lapangan :\n");
		for(int i=0; i<jumlah; i++){
			System.out.println("==========================================");
			System.out.println("No Lapangan : " +No_Lapangan[i]);
			System.out.println("Nama : " +Nama[i]);
			System.out.println("Jenis Lapangan : " +Jenis_Lapangan[i]);
        }
	}

	public static boolean search(int l) {
		for(int i=0; i<jumlah; i++){
			if (No_Lapangan[i] == l) {
				System.out.println("Data Penyewa Ditemukan : ");
				System.out.println("No Lapangan : " +No_Lapangan[i]);
				System.out.println("Nama : " +Nama[i]);
				System.out.println("Jenis Lapangan : " +Jenis_Lapangan[i]);
				return true;
			}
		}
		return false;
	}
	
	public static boolean update(int l) {
		for(int i=0; i<jumlah; i++){
			if (No_Lapangan[i] == l) {
				System.out.print("Masukkan No Lapangan Baru : ");
				No_Lapangan[i] = in.nextInt();
				System.out.print("Masukkan Nama Penyewa Baru : ");				
				Nama[i] = in.next();						            
				System.out.print("Masukkan Jenis Lapangan Baru : ");
				Jenis_Lapangan[i] = in.next();
				return true;
			}
		}
		int r = No_Lapangan.length;
		for (int i=1; i<r;i++) {
			for (int h=0; h<r-1;h++) {
				if (No_Lapangan[h+1]<No_Lapangan[h]) {
					int tmp=No_Lapangan[h+1];
					String tmp1=Nama[h+1];
					String tmp2=Jenis_Lapangan[h+1];
					No_Lapangan[h+1]=No_Lapangan[h];
					Nama[h+1]=Nama[h];
					Jenis_Lapangan[h+1]=Jenis_Lapangan[h];
					No_Lapangan[h]=tmp;
					Nama[h]=tmp1;
					Jenis_Lapangan[h]=tmp2;
				}
			}
		}
		return false;
	}
	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int a = 1;
		Rental_Futsal q = new Rental_Futsal();
		for (;a == 1;) {
			System.out.println("==========================================");
			System.out.print("1. Masukkan Data Penyewa\n2. Lihat Data Penyewa\n3. Update Data Penyewa\n4. Delete Data Penyewa\n5. Cari Data Penyewa\n6. Keluar\nPilihan Anda\t: ");
			int menu = in.nextInt();		
			System.out.println("==========================================");
	  switch (menu) {
		case 1: {
			System.out.print("Masukkan No Lapangan Penyewa : ");
			int j = in.nextInt();
			System.out.print("Masukkan Nama Penyewa : ");				
			String k = in.next();						            
			System.out.print("Masukkan Jenis Lapangan Penyewa : ");
			String l = in.next();
			insert(j,k,l);
			break;
		}		
		case 2: {
			view();
			break;
		}
		case 3: {
			System.out.print("Masukkan No Lapangan Penyewa : ");
			int l = in.nextInt();
			if (update(l)){
			}
			else {
				System.out.println("Data Tidak ada");
			}
			break;
		}
		case 4: {
			remove();
			break;
		}	
		case 5: {
			System.out.print("Masukkan No Lapangan Penyewa : ");
			int l = in.nextInt();
			if (search(l)){
			}
			else {
				System.out.println("Data Tidak Ditemukan");
			}
			break;
		}		
		case 6: {
			System.out.println("Terima Kasih");
			System.exit(0);
		}	
		default : System.out.println("Pilihan Tidak Ada!!!");
	  }
    }
  }
}
