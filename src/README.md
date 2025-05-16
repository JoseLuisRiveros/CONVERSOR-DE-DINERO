/**
* ========================================================
* 💱 CONVERSOR DE DIVISAS - Documentación Java (IntelliJ)
* ========================================================
*
* @descripciónProyecto Aplicación Java para conversión monetaria en tiempo real
* con tasas actualizadas, historial de operaciones y configuración personalizable.
*
* @badges
* ![Java](https://img.shields.io/badge/Java-17%2B-blue)
* ![IntelliJ](https://img.shields.io/badge/IntelliJ-IDEA-purple)
*
* 🔥 PRINCIPALES FUNCIONALIDADES 🔥
*
* @caracteristicasDestacadas
* 🌐 CONVERSIÓN EN TIEMPO REAL ENTRE 9 MONEDAS:
*    - USD (Dólar Estadounidense)
*    - EUR (Euro)
*    - GBP (Libra Esterlina)
*    - JPY (Yen Japonés)
*    - ARS (Peso Argentino)
*    - BOB (Boliviano Boliviano)
*    - BRL (Real Brasileño)
*    - CLP (Peso Chileno)
*    - COP (Peso Colombiano)
*
* 📊 HISTORIAL COMPLETO:
*    - Registro automático de todas las conversiones
*    - Visualización cronológica
*
* ⚡ TASAS ACTUALIZADAS:
*    - Conexión con ExchangeRate-API
*    - Valores por defecto como respaldo
*
* 🎯 PRECISIÓN DECIMAL:
*    - 2 decimales exactos (sin redondeo)
*    - Cálculos con alta precisión
*
* ⚙️ CONFIGURACIÓN AVANZADA:
*    - Personalización mediante archivo config.properties
*    - Tiempo de caché ajustable
*
* 🖥️ INTERFAZ INTUITIVA:
*    - Menú interactivo en consola
*    - Instrucciones claras
*
* 📌 CONFIGURACIÓN INICIAL
*
* @requisitos
* ✔️ Java JDK 11 o superior
* ✔️ Maven (gestión de dependencias)
* ✔️ API Key gratuita de ExchangeRate-API
*
* @archivoConfiguracion config.properties:
*
* // INICIO DEL ARCHIVO
* api.url=https://v6.exchangerate-api.com/v6/
* api.key=TU_CLAVE_API
* currencies=USD,EUR,GBP,JPY,ARS,BOB,BRL,CLP,COP
* cache.minutes=60
* // FIN DEL ARCHIVO
*
* 📦 DEPENDENCIAS
*
* @bibliotecas
* - Gson 2.10.1 (procesamiento JSON)
* - Java HTTP Client (llamadas API)
*
* Configuración para pom.xml:
*
* <dependencies>
*     <dependency>
*         <groupId>com.google.code.gson</groupId>
*         <artifactId>gson</artifactId>
*         <version>2.10.1</version>
*     </dependency>
* </dependencies>
*
* 🚀 CÓMO EJECUTAR
*
* @compilacionEjecucion
* 1. Compilar:
*    javac -cp ".;gson-2.10.1.jar" src/*.java -d out/
*
* 2. Ejecutar:
*    java -cp "out/;gson-2.10.1.jar" Main
*
* @menuPrincipal
* === CONVERSOR DE DIVISAS ===
* 1. Convertir moneda
* 2. Ver historial
* 3. Actualizar tasas
* 4. Salir
*
* @ejemploConversion
* Moneda origen (ej. USD): ARS
* Moneda destino (ej. EUR): USD
* Cantidad a convertir: 1000
* Resultado: 1000.00 ARS = 0.87 USD
*
* 🏗️ ESTRUCTURA DEL PROYECTO
*
* @arquitectura
* src/
* ├── Main.java                 // Punto de entrada
* ├── Config.java               // Gestor de configuración
* ├── CurrencyConverter.java    // Lógica de conversión
* ├── ExchangeRateCache.java    // Almacenamiento de tasas
* ├── ConversionHistory.java    // Administrador de historial
* └── Currency.java             // Modelo de datos
*
* 🚧 MEJORAS FUTURAS
*
* @roadmap
* 🟢 Interfaz gráfica (JavaFX/Swing)
* 🟡 Soporte para criptomonedas
* 🔴 Base de datos SQLite
* 🔵 Múltiples APIs de respaldo
*
* 📄 LICENCIA
* MIT License - Uso y modificación libres
*
* ❓ SOPORTE
* ¿Preguntas o problemas? ¡Abre un issue en el repositorio!
*
* 👨💻 DESARROLLADOR
* Creado con ❤️ por [Jose Luis Riveros]
*
* 💡 NOTAS ADICIONALES
* - Tasas actualizables manualmente en ExchangeRateCache.java
* - Modo offline con valores predefinidos
* - Para máxima precisión: usar APIs premium como Alpha Vantage
    */