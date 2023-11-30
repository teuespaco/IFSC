import http.server
import socketserver

class MyHandler(http.server.SimpleHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header('Content-type', 'text/html')
        self.end_headers()
        self.wfile.write(b'HTTP/1.1 200 OK\n\n')
        with open('pagina.html', 'rb') as f:
            self.wfile.write(f.read())

PORT = 80

with socketserver.TCPServer(("", PORT), MyHandler) as httpd:
    print("Servindo na porta", PORT)
    httpd.serve_forever()



