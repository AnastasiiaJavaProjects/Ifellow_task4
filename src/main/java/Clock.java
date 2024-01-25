public class Clock {
    public static void main(String[] args) {
        calculateAngle(20, 13);
    }

    public static void calculateAngle(int hours, int minutes){
        double round = 360;
        double minutesPerHour = 60;
        double hoursPerRound = 12;

        checkTimeCorrectness(hours, minutes);
        hours = convertHoursInto12Format(hours);

        //Угол от одной отметки до другой для минут и для часов
        double oneSectionDegreesForMinute = round / minutesPerHour;
        double oneSectionDegreesForHour = round / hoursPerRound;

        //Угол отклонения минутной и часовой стрелки относительно 12 часов
        double minutesAngle = oneSectionDegreesForMinute * minutes;
        double hoursAngle = (hours * oneSectionDegreesForHour) + ((minutes * oneSectionDegreesForHour) / minutesPerHour);

        //Угол между стрелками
        double angle = Math.abs(minutesAngle - hoursAngle);

        System.out.println("Угол между часовой и минутной стрелкой составляет " + angle + " градусов.");
    }

    //Конвертация часов в 12-часовой формат
    private static int convertHoursInto12Format(int hours){
        if(hours >= 12){
            hours = hours - 12;
        }
        return hours;
    }

    //Проверка допустимости значений для часов и минут
    private static void checkTimeCorrectness(int hours, int minutes){
        String errorMessage = "";
        if(hours < 0){
            errorMessage += "\nКоличество часов должно быть больше 0";
        }
        if(hours >= 24){
            errorMessage += "\nКоличество часов должно быть меньше 24";
        }
        if(minutes < 0){
            errorMessage += "\nКоличество минут должно быть больше 0";
        }
        if(minutes >= 60){
            errorMessage += "\nКоличество минут должно быть меньше 60";
        }
        if(!errorMessage.isEmpty()){
            throw new IllegalArgumentException("Вы задали некорректное время:" + errorMessage);
        }
    }
}