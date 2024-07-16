package com.example.taskboardbackend.DTO;
/**
 * Тут пишем Data Transfer Objects, их следует использовать везде, кроме Service. Используем Record.
 * То есть: Приняли Entity в ServiceDB из метода репозитория -> Преобразовали Entity в DTO -> Передали DTO в логику ->
 * -> Работаем дальше только с DTO.
 * И наоборот: Приняли DTO из контроллера -> Передали DTO в логику -> Что-то сделали c DTO -> Передали DTO в Service DB ->
 * -> Преобразовали DTO в Entity в ServiceDB -> Передали Entity в метод репозитория
 */

