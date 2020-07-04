from flask import Flask, request, jsonify, Response, render_template
import json
import operator
import pandas as pd
from flaskext.mysql import MySQL
from flask_cors import CORS
from decimal import Decimal
import pymysql


app = Flask(__name__)
CORS(app)


# app.config['MYSQL_DATABASE_USER'] = 'sigadis'
# app.config['MYSQL_DATABASE_PASSWORD'] = 'password'
# app.config['MYSQL_DATABASE_HOST'] = 'localhost'
# app.config['MYSQL_DATABASE_DB'] = 'db_sigadis'
# app.config['MYSQL_DATABASE_SOCKET'] = '/tmp/mysql.sock'

# global mysql
# mysql = MySQL()
# mysql.init_app(app)

global cur
# cur = mysql.connect().cursor()

conn = pymysql.connect(host='localhost', 
                        user='sigadis',
                        password='password',
                        database='fastreg',  
                        port=3306)
cur = conn.cursor()

print('Yeay')


##Page HTML

@app.route("/")
def home():
  return render_template("dashboard.html")

@app.route("/dashboard")
def dashboard():
  return render_template("dashboard.html")

@app.route("/list")
def about():
  return render_template("list.html")

##API

@app.route('/insert_kelahiran', methods=['POST'])
def insert_kelahiran():
    text = request.get_json()
    tenkes_id = text['tenkes_id']
    tanggal = text['tanggal']
    jam = text['jam']
    jenis_kelamin = text['jenis_kelamin']
    jenis_kelahiran = text['jenis_kelahiran']
    kelahiran_ke = text['kelahiran_ke']
    berat_lahir = text['berat_lahir']
    panjang_badan = text['panjang_badan']
    nama = text['nama']
    nama_ibu = text['nama_ibu']
    umur_ibu = text['umur_ibu']
    pekerjaan_ibu = text['pekerjaan_ibu']
    no_ktp_ibu = text['no_ktp_ibu']
    nama_ayah = text['nama_ayah']
    umur_ayah = text['umur_ayah']
    pekerjaan_ayah = text['pekerjaan_ayah']
    no_ktp_ayah = text['no_ktp_ayah']
    alamat = text['alamat']
    kecamatan = text['kecamatan']
    kabupaten_kota = text['kabupaten_kota']
    scan_ktp_ibu = text['scan_ktp_ibu']
    scan_ktp_ayah = text['scan_ktp_ayah']
    scan_surat_nikah = text['scan_surat_nikah']
    pdf_skl = text['pdf_skl']
    kelahiran_id = str(provinsi)+str(kabupaten_kota)+str(kecamatan)+str()

    sql_insert_kelahiran = "INSERT INTO kelahiran (kelahiran_id,tenkes_id,tanggal,jam,jenis_kelamin,jenis_kelahiran,kelahiran_ke,berat_lahir,panjang_badan,nama,nama_ibu,umur_ibu,pekerjaan_ibu,no_ktp_ibu,nama_ayah,umur_ayah,pekerjaan_ayah,no_ktp_ayah,alamat,kecamatan,kabupaten_kota,scan_ktp_ibu,scan_ktp_ayah,scan_surat_nikah,pdf_skl) VALUES ('"+str(kelahiran_id)+"','"+str(tenkes_id)+"','"+str(tanggal)+"','"+str(jam)+"','"+str(jenis_kelamin)+"','"+str(jenis_kelahiran)+"','"+str(kelahiran_ke)+"','"+str(berat_lahir)+"','"+str(panjang_badan)+"','"+str(nama)+"','"+str(nama_ibu)+"','"+str(umur_ibu)+"','"+str(pekerjaan_ibu)+"','"+str(no_ktp_ibu)+"','"+str(nama_ayah)+"','"+str(umur_ayah)+"','"+str(pekerjaan_ayah)+"','"+str(no_ktp_ayah)+"','"+str(alamat)+"','"+str(kecamatan)+"','"+str(kabupaten_kota)+"','"+str(scan_ktp_ibu)+"','"+str(scan_ktp_ayah)+"','"+str(scan_surat_nikah)+"','"+str(pdf_skl)+"');"

    cur.execute(sql_insert_kelahiran)


@app.route('/riwayat_kelahiran', methods=['POST', 'GET'])
def riwayat_kelahiran():
    text = request.get_json()
    tenkes_id = text['tenkes_id']

    sql_riwayat_kelahiran = "SELECT nama, tanggal, jam FROM kelahiran WHERE tenkes_id='"+str(tenkes_id)+"';"

    # hasil = cur.execute(sql_riwayat_kelahiran)
    
    cur.execute(sql_riwayat_kelahiran)
    df = pd.DataFrame(cur.fetchall(), index=None, columns=[i[0] for i in cur.description])

    print(df)
    df['tanggal'] = df['tanggal'].astype(str)
    df['jam'] = df['jam'].astype(str)
    df = df.to_json()
    print(df)
    # response = []
    # for i in range(0, len(df)):
    #     tmp = {}
    #     response['nama'] = df['nama'][i]
    #     response['tanggal'] = df['tanggal'][i]
    #     response['jam'] = df['jam'][i]
    #     response.append(tmp)


    return jsonify(df)


@app.route('/edit_kelahiran', methods=['POST', 'GET'])
def edit_kelahiran():
    text = request.get_json()
    kelahiran_id = text['kelahiran_id']

    sql_edit_kelahiran = "SELECT kelahiran_id,tenkes_id,tanggal,jam,jenis_kelamin,jenis_kelahiran,kelahiran_ke,berat_lahir,panjang_badan,nama,nama_ibu,umur_ibu,pekerjaan_ibu,no_ktp_ibu,nama_ayah,umur_ayah,pekerjaan_ayah,no_ktp_ayah,alamat,kecamatan,kabupaten_kota,scan_ktp_ibu,scan_ktp_ayah,scan_surat_nikah,pdf_skl FROM kelahiran WHERE kelahiran_id='"+str(kelahiran_id)+"';"
    
    hasil = cur.execute(sql_edit_kelahiran)
    df = pd.DataFrame(hasil.fetchall(), columns=hasil.keys())
    df_json = df.to_json()

    return jsonify(df_json)

@app.route('/update_kelahiran', methods=['POST', 'GET'])
def update_kelahiran():
    text = request.get_json()
    kelahiran_id = text['kelahiran_id']
    tenkes_id = text['tenkes_id']
    tanggal = text['tanggal']
    jam = text['jam']
    jenis_kelamin = text['jenis_kelamin']
    jenis_kelahiran = text['jenis_kelahiran']
    kelahiran_ke = text['kelahiran_ke']
    berat_lahir = text['berat_lahir']
    panjang_badan = text['panjang_badan']
    nama = text['nama']
    nama_ibu = text['nama_ibu']
    umur_ibu = text['umur_ibu']
    pekerjaan_ibu = text['pekerjaan_ibu']
    no_ktp_ibu = text['no_ktp_ibu']
    nama_ayah = text['nama_ayah']
    umur_ayah = text['umur_ayah']
    pekerjaan_ayah = text['pekerjaan_ayah']
    no_ktp_ayah = text['no_ktp_ayah']
    alamat = text['alamat']
    kecamatan = text['kecamatan']
    kabupaten_kota = text['kabupaten_kota']
    scan_ktp_ibu = text['scan_ktp_ibu']
    scan_ktp_ayah = text['scan_ktp_ayah']
    scan_surat_nikah = text['scan_surat_nikah']
    pdf_skl = text['pdf_skl']

    sql_update_kelahiran = "UPDATE kelahiran SET kelahiran_id='"+str(kelahiran_id)+"',tenkes_id='"+str(tenkes_id)+"',tanggal='"+str(tanggal)+"',jam='"+str(jam)+"',jenis_kelamin='"+str(jenis_kelamin)+"',jenis_kelahiran='"+str(jenis_kelahiran)+"',kelahiran_ke='"+str(kelahiran_ke)+"',berat_lahir='"+str(berat_lahir)+"',panjang_badan='"+str(panjang_badan)+"',nama='"+str(nama)+"',nama_ibu='"+str(nama_ibu)+"',umur_ibu='"+str(umur_ibu)+"',pekerjaan_ibu='"+str(pekerjaan_ibu)+"',no_ktp_ibu='"+str(no_ktp_ibu)+"',nama_ayah='"+str(nama_ayah)+"',umur_ayah='"+str(umur_ayah)+"',pekerjaan_ayah='"+str(pekerjaan_ayah)+"',no_ktp_ayah='"+str(no_ktp_ayah)+"',alamat='"+str(alamat)+"',kecamatan='"+str(kecamatan)+"',kabupaten_kota='"+str(kabupaten_kota)+"',scan_ktp_ibu='"+str(scan_ktp_ibu)+"',scan_ktp_ayah='"+str(scan_ktp_ayah)+"',scan_surat_nikah='"+str(scan_surat_nikah)+"',pdf_skl='"+str(pdf_skl)+"' WHERE kelahiran_id='"+str(kelahiran_id)+"';"

    cur.execute(sql_update_kelahiran)
    return Response(200)

@app.route('/delete_kelahiran', methods=['POST', 'GET'])
def delete_kelahiran():
    text = request.get_json()
    kelahiran_id = text['kelahiran_id']

    sql_delete_kelahiran = "DELETE FROM kelahiran WHERE kelahiran_id='"+str(kelahiran_id)+"';"

    cur.execute(sql_delete_kelahiran)
    return Response(200)

@app.route('/dashboard_kelahiran', methods=['GET'])
def dashboard_kelahiran():
    return Response(200)

    
    # TFR = 
    # ASFR =
    # GNR =

#Kematian
@app.route('/search_kematian', methods=['POST', 'GET'])
def search_kematian():
    text = request.get_json()
    kelahiran_id = text['kelahiran_id']

    sql_search_kematian = "SELECT nama, tanggal FROM kelahiran WHERE kelahiran_id='"+str(kelahiran_id)+"';"

    cur.execute(sql_search_kematian)



@app.route('/insert_kematian', methods=['POST'])
def insert_kematian():
    text = request.get_json()
    kematian_id = text['kematian_id']
    kelahiran_id = text['kelahiran_id']
    tenkes_id = text['tenkes_id']
    tanggal = text['tanggal']
    jam = text['jam']
    pdf_skm = text['pdf_skm']

    sql_insert_kematian = "INSERT INTO kematian (kematian_id,kelahiran_id,tenkes_id,tanggal,jam,pdf_skm) VALUES ('"+str(kematian_id)+"','"+str(kelahiran_id)+"','"+str(tenkes_id)+"','"+str(tanggal)+"','"+str(jam)+"','"+str(pdf_skm)+"';"

    cur.execute(sql_insert_kematian)

@app.route('/riwayat_kematian', methods=['POST', 'GET'])
def riwayat_kematian():
    text = request.get_json()
    tenkes_id = text['tenkes_id']

    sql_riwayat_kematian = "SELECT nama, tanggal, jam FROM kematian WHERE tenkes_id='"+str(tenkes_id)+"';"

    hasil = cur.execute(sql_riwayat_kematian)
    df = pd.DataFrame(hasil.fetchall(), columns=hasil.keys())

    response = []
    for i in range(0, len(hasil)):
        tmp = {}
        response['nama'] = df['nama'][i]
        response['tanggal'] = df['tanggal'][i]
        response['jam'] = df['jam'][i]
        response.append(tmp)


    return jsonify(response)

@app.route('/edit_kematian', methods=['POST', 'GET'])
def edit_kematian():
    text = request.get_json()

@app.route('/delete_kematian', methods=['POST', 'GET'])
def delete_kematian():
    text = request.get_json()

@app.route('/dashboard_kematian', methods=['POST', 'GET'])
def dashboard_kematian():
    text = request.get_json()

@app.route('/tenkes', methods=['GET'])
def tenkes():
    text = request.get_json()

@app.route('/login_android', methods=['GET'])
def login_android():
    text = request.get_json()

@app.route('/login_web', methods=['GET'])
def login_web():
    text = request.get_json()

##Batas Bawah

print('Yeay Kedua')

if __name__ == '__main__':
    app.run(debug=True, port = 9090)

