import java.util.HashMap;

class AlienNumeralConverter { // สร้าง class คลาสนี้เป็นที่รวมฟังก์ชันที่ใช้สำหรับแปลงเลข Alien numeral เป็นจำนวนเต็ม โดยมีฟังก์ชันหลักคือ alienToInteger
    public static int alienToInteger(String s) {
        // สร้างแผนที่ (HashMap) เพื่อเก็บค่าสัญลักษณ์ Alien numeral
        HashMap<Character, Integer> alienValues = new HashMap<>();
        alienValues.put('A', 1);
        alienValues.put('B', 5);
        alienValues.put('Z', 10);
        alienValues.put('L', 50);
        alienValues.put('C', 100);
        alienValues.put('D', 500);
        alienValues.put('R', 1000);

        int total = 0; // ตัวแปรสำหรับผลรวม
        int prevValue = 0; // ตัวแปรเก็บค่าสัญลักษณ์ก่อนหน้า

        // วนลูปจากขวาไปซ้ายของสตริง
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            int currentValue = alienValues.get(currentChar);

            // กรณีที่ค่าน้อยกว่าค่าก่อนหน้า ให้ลบออก
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                // ถ้าไม่ใช่ ให้บวกเพิ่ม
                total += currentValue;
            }

            // อัปเดตค่าก่อนหน้า (prevValue)
            prevValue = currentValue;
        }

        return total; // คืนค่าผลรวม
    }
}

public class Test_backend { // เปลี่ยนคลาสนี้ให้เป็น public
    public static void main(String[] args) {
        // การใช้งาน
        System.out.println("Input: AAA, Output: " + AlienNumeralConverter.alienToInteger("AAA")); // 3
        System.out.println("Input: LBAAA, Output: " + AlienNumeralConverter.alienToInteger("LBAAA")); // 58
        System.out.println("Input: RCRZCAB, Output: " + AlienNumeralConverter.alienToInteger("RCRZCAB")); // 1994
    }
}
