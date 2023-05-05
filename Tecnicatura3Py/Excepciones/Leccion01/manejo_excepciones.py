from NumerosIgualesException import  NumerosIgualesException

resultado = None


try:
    a = int(input('Digite un numero: '))
    b = int(input('Digite un numero: '))
    if a == b:
        raise NumerosIgualesException('Son numeros iguales')
    resultado = a/b # modificamos
except TypeError as e:
    print(f'TypeError - Ocurrió un ERROR: {type(e)}')
except ZeroDivisionError as e:
    print(f'ocurrió un ERROR: {e}')
except Exception as e:
    print(f'Ocurrió un ERROR: {e}')
else:
    print('No se arroo ninguna escepcion')
finally: # siempre se va a ejecuta
    print('Ejecucion de este bloque finally')

print(f'el resultado es: {resultado}')
print('seguimos...')