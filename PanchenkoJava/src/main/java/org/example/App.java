package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static final Logger logger = LogManager.getLogger(App.class); // Инициализация логгера

    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in); // Объявление и инициализация Scanner
        BufferedReader reader = null; // Объявление Reader
        try { // Попытка инициализации Reader
            reader = new BufferedReader(new InputStreamReader(System.in, ConstantsValues.CHARSET_NAME));
        } catch (UnsupportedEncodingException e) {
            logger.error(e);
        }
        logger.info(ConstantsValues.INPUT_TASK_NUMBER); // Информационное сообщение
        int taskNumber;
        try {
            taskNumber = scanner.nextInt(); // Попытка ввода номера задания
        } catch (Exception e) {
            logger.error(e);
            return;
        }
        switch (taskNumber){ // Выполнение задания по введённому номеру
            case 0:
                logger.error(ConstantsValues.ERROR_TASK_NOT_EXIST); // Информационное сообщение об ошибке
                return;
            case 1: // Выполнение первого задания
                logger.info(ConstantsValues.TASK + taskNumber); // Объявление номера задания
                logger.info(ConstantsValues.INPUT_NUMBER); // Сообщение - программа ожидает ввод от пользователя
                int number = scanner.nextInt(); // Ввод числа
                if(number > 7){ // Проверка условия
                    System.out.println(ConstantsValues.HELLO); // Вывод, если число больше 7
                }
                return;
            case 2:
                logger.info(ConstantsValues.TASK + taskNumber); // Объявление номера задания
                logger.info(ConstantsValues.INPUT_NAME); // Сообщение - программа ожидает ввод от пользователя
                String name = null;
                try {
                    assert reader != null;
                    name = reader.readLine();
                } catch (IOException e) {
                    logger.error(e);
                }
                assert name != null;
                if (Objects.equals(name.toLowerCase(Locale.ROOT), ConstantsValues.CORRECT_NAME_IN_LOWER_CASE)){
                    System.out.println(ConstantsValues.HELLO + ConstantsValues.GAP + ConstantsValues.CORRECT_NAME);
                }
                else {
                    System.out.println(ConstantsValues.NAME_NOT_EXIST);
                }
                return;
            case 3:
                logger.info(ConstantsValues.TASK + taskNumber); // Объявление номера задания
                logger.info(ConstantsValues.INPUT_ARRAY_SIZE); // Сообщение - программа ожидает ввод от пользователя
                int size = scanner.nextInt(); // Ввод размера массива
                int[] inputArray = new int[size]; // Объявление будущего массива
                logger.info(ConstantsValues.INPUT_ARRAY_DATA); // Сообщение - программа ожидает ввод от пользователя
                for (int i = 0; i < size; i++) { // Заполнение данных пользователем
                    inputArray[i] = scanner.nextInt();
                }
                for (int i = 0; i < size; i++) { // Вывод элементов, кратных трём
                    if(inputArray[i] % 3 == 0){
                        System.out.print (inputArray[i] + ConstantsValues.GAP_FOR_ARRAY);
                    }
                }
                break;
            default:
                logger.error(ConstantsValues.ERROR_TASK_NOT_EXIST); // В случае неправильного ввода задания
        }
    }

}
