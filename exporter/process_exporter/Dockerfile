# Используем базовый образ ncabatoff/process-exporter:latest
FROM ncabatoff/process-exporter:latest

# Указываем рабочую директорию
WORKDIR /etc/process_exporter

# Копируем конфигурацию process_exporter.yml в образ
COPY process_exporter.yml /etc/process_exporter/config.yml

# Команда для запуска process_exporter
CMD [ "-config.path=/etc/process_exporter/config.yml" ]
