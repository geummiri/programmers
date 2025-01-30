import java.util.*;


class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int start = getTime(op_start),
            end = getTime(op_end),
            video = getTime(video_len),
            posLen = getTime(pos);
        if(start <= posLen && end >= posLen) posLen = end;
        for (String command : commands) {
            if(command.equals("prev")) {
                posLen = posLen - 10 > 0 ? posLen - 10 : 0;
            } else {
                posLen = posLen+10 >= video ? video : posLen+10;
            }
            if(start <= posLen && end >= posLen)
                posLen = end;
        }
        return String.format("%02d:%02d", posLen/60, posLen%60);
    }
    private int getTime(String time) {
    int min = Integer.parseInt(time.split(":")[0])*60;
    int sec = Integer.parseInt(time.split(":")[1]);
    return min + sec;
     }
}