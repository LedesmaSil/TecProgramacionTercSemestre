# declaramos una variable
try:
    archivo = open('prueba.txt','w', encoding='utf8')  # la w es de white que significa escribir
    archivo.write('Programamos con diferentes tipos de archivos, ahora en txt.\n')
    archivo.write('Los acentos son importantes para las palabras.\n')
    archivo.write('como por ejemplo: acción, ejecución y producción\n')
    archivo.write('las letras son:\n r read leer,\n a append anexa,\n w write escribe,\n x crea un archivo')
    archivo.write('t texto o text,\n b archivos binarios, \n w+ lee y escribe son iguales r+\n')
    archivo.write('Saludos a todos los alumnos de la tecnicatura\n')
    archivo.write('Con esto terminamos\n')
except Exception as e:
    print(e)
finally: # siempre se ejecutivo
    archivo.close() # con esto se debe cerrar el archivo

# archivo.write('Todo quedo perfecto'): este es un error
