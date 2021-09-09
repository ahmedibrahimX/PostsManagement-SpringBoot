# Posts Management System

## Introduction

> This is a simple backend project for practicing creating APIs using Spring Boot in a 3 Layered Architecture using Java



## Project Idea

[![](https://mermaid.ink/img/eyJjb2RlIjoiZmxvd2NoYXJ0IExSXG5cdFJTU1svUlNTX0ZlZWQvXSAtLT4gUGFyc2VyX0NvbnZlcnRpbmdfUlNTX1RvX0RhdGEgLS0-IERCWyhEYXRhQmFzZSldIiwibWVybWFpZCI6eyJ0aGVtZSI6ImRlZmF1bHQifSwidXBkYXRlRWRpdG9yIjpmYWxzZSwiYXV0b1N5bmMiOnRydWUsInVwZGF0ZURpYWdyYW0iOmZhbHNlfQ)](https://mermaid-js.github.io/mermaid-live-editor/edit##eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cdGNsYXNzIFBhcnNlciB7XG5cdFx0K1BhcnNlQmVoYXZpb3IgcGFyc2VCZWhhdmlvclxuXHRcdCtnZXRSc3NQb3N0cygpXG5cdH1cblx0Y2xhc3MgUGFyc2VCZWhhdmlvciB7XG5cdFx0PDxJbnRlcmZhY2U-PlxuXHRcdCtwYXJzZSgpXG5cdH1cblx0Y2xhc3MgSnNvblBhcnNlSW1wbCB7XG5cdFx0K0NsYXNzIHNvdXJjZUNsYXNzXG5cdFx0K3BhcnNlKClcblx0fVxuXHRjbGFzcyBYbWxQYXJzZUltcGwge1xuXHRcdCtDbGFzcyBzb3VyY2VDbGFzc1xuXHRcdCtwYXJzZSgpXG5cdH1cblx0Y2xhc3MgTmV3c1NvdXJjZSB7XG5cdFx0PDxJbnRlcmZhY2U-PlxuXHRcdCttYXBOZXdzVG9Qb3N0cygpXG5cdH1cblx0Y2xhc3MgTmV3c1NvdXJjZUltcGxBIHtcblx0XHQrTGlzdDxOZXdzSXRlbUltcGxBPiBuZXdzSXRlbXNcblx0XHQrbWFwTmV3c1RvUG9zdHMoKVxuXHR9XG5cdGNsYXNzIE5ld3NJdGVtIHtcblx0XHQ8PEludGVyZmFjZT4-XG5cdFx0K21hcEl0ZW1Ub1Bvc3QoKVxuXHR9XG5cdGNsYXNzIE5ld3NJdGVtSW1wbEEge1xuXHRcdCttYXBJdGVtVG9Qb3N0KClcblx0fVxuXHRQYXJzZXIgKi0tIFBhcnNlQmVoYXZpb3Jcblx0UGFyc2VCZWhhdmlvciA8fC0tIEpzb25QYXJzZUltcGxcblx0UGFyc2VCZWhhdmlvciA8fC0tIFhtbFBhcnNlSW1wbFxuXHROZXdzSXRlbSA8fC0tIE5ld3NJdGVtSW1wbEFcblx0TmV3c1NvdXJjZSA8fC0tTmV3c1NvdXJjZUltcGxBXG5cdE5ld3NTb3VyY2VJbXBsQSAqLS0gTmV3c0l0ZW1JbXBsQVxuXHRKc29uUGFyc2VJbXBsICotLSBOZXdzU291cmNlXG5cdFhtbFBhcnNlSW1wbCAqLS0gTmV3c1NvdXJjZSIsIm1lcm1haWQiOiJ7XG4gIFwidGhlbWVcIjogXCJkZWZhdWx0XCJcbn0iLCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)



## Project Design

### Parser

[![](https://mermaid.ink/img/eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cdGNsYXNzIFBhcnNlciB7XG5cdFx0K1BhcnNlQmVoYXZpb3IgcGFyc2VCZWhhdmlvclxuXHRcdCtnZXRSc3NQb3N0cygpXG5cdH1cblx0Y2xhc3MgUGFyc2VCZWhhdmlvciB7XG5cdFx0PDxJbnRlcmZhY2U-PlxuXHRcdCtwYXJzZSgpXG5cdH1cblx0Y2xhc3MgSnNvblBhcnNlSW1wbCB7XG5cdFx0K0NsYXNzIHNvdXJjZUNsYXNzXG5cdFx0K3BhcnNlKClcblx0fVxuXHRjbGFzcyBYbWxQYXJzZUltcGwge1xuXHRcdCtDbGFzcyBzb3VyY2VDbGFzc1xuXHRcdCtwYXJzZSgpXG5cdH1cblx0Y2xhc3MgTmV3c1NvdXJjZSB7XG5cdFx0PDxJbnRlcmZhY2U-PlxuXHRcdCttYXBOZXdzVG9Qb3N0cygpXG5cdH1cblx0Y2xhc3MgTmV3c1NvdXJjZUltcGxBIHtcblx0XHQrTGlzdDxOZXdzSXRlbUltcGxBPiBuZXdzSXRlbXNcblx0XHQrbWFwTmV3c1RvUG9zdHMoKVxuXHR9XG5cdGNsYXNzIE5ld3NJdGVtIHtcblx0XHQ8PEludGVyZmFjZT4-XG5cdFx0K21hcEl0ZW1Ub1Bvc3QoKVxuXHR9XG5cdGNsYXNzIE5ld3NJdGVtSW1wbEEge1xuXHRcdCttYXBJdGVtVG9Qb3N0KClcblx0fVxuXHRQYXJzZXIgKi0tIFBhcnNlQmVoYXZpb3Jcblx0UGFyc2VCZWhhdmlvciA8fC0tIEpzb25QYXJzZUltcGxcblx0UGFyc2VCZWhhdmlvciA8fC0tIFhtbFBhcnNlSW1wbFxuXHROZXdzSXRlbSA8fC0tIE5ld3NJdGVtSW1wbEFcblx0TmV3c1NvdXJjZSA8fC0tTmV3c1NvdXJjZUltcGxBXG5cdE5ld3NTb3VyY2VJbXBsQSAqLS0gTmV3c0l0ZW1JbXBsQVxuXHRKc29uUGFyc2VJbXBsICotLSBOZXdzU291cmNlXG5cdFhtbFBhcnNlSW1wbCAqLS0gTmV3c1NvdXJjZSIsIm1lcm1haWQiOnsidGhlbWUiOiJkZWZhdWx0In0sInVwZGF0ZUVkaXRvciI6ZmFsc2UsImF1dG9TeW5jIjp0cnVlLCJ1cGRhdGVEaWFncmFtIjpmYWxzZX0)](https://mermaid-js.github.io/mermaid-live-editor/edit##eyJjb2RlIjoiY2xhc3NEaWFncmFtXG5cdGNsYXNzIElCZWhhdmlvciB7XG5cdFx0PDxJbnRlcmZhY2U-PlxuXHRcdCtydW4oKVxuXHR9XG5cdGNsYXNzIENvbmNyZXRlQmVoYXZpb3JBIHtcblx0XHQrcnVuKClcblx0fVxuXHRjbGFzcyBDb25jcmV0ZUJlaGF2aW9yQiB7XG5cdFx0K3J1bigpXG5cdH1cblx0Y2xhc3MgQ2xpZW50IHtcblx0XHQrSUJlaGF2aW9yIGJlaGF2aW9yXG5cdFx0K2V4ZWN1dGUoKVxuXHR9XG5cdFxuXHRDbGllbnQgKi0tIElCZWhhdmlvclxuXHRJQmVoYXZpb3IgPHwtLSBDb25jcmV0ZUJlaGF2aW9yQVxuXHRJQmVoYXZpb3IgPHwtLSBDb25jcmV0ZUJlaGF2aW9yQiIsIm1lcm1haWQiOiJ7XG4gIFwidGhlbWVcIjogXCJkZWZhdWx0XCJcbn0iLCJ1cGRhdGVFZGl0b3IiOmZhbHNlLCJhdXRvU3luYyI6dHJ1ZSwidXBkYXRlRGlhZ3JhbSI6ZmFsc2V9)

*The ParseBehavior implementation is configured through the constructor to use one of the NewsSource class concretions, also the Parser is configured through the constructor to use one of the ParseBehavior class concretions.*

***



