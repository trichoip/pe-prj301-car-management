USE [master]
GO
/****** Object:  Database [CarManagement]    Script Date: 07/11/2022 00:35:57 ******/
CREATE DATABASE [CarManagement] 
GO
USE [CarManagement]
GO

CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](50) NOT NULL,
	[fullName] [nvarchar](500) NOT NULL,
	[roleID] [char](2) NOT NULL,
	[password] [varchar](50) NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblUsers] ([userID], [fullName], [roleID], [password]) VALUES (N'ADMIN', N'Toi is Administrator', N'AD', N'1')
INSERT [dbo].[tblUsers] ([userID], [fullName], [roleID], [password]) VALUES (N'HD', N'Toi la User', N'US', N'1')
/****** Object:  Table [dbo].[tblCars]    Script Date: 07/11/2022 00:35:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblCars](
	[id] [char](5) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](500) NOT NULL,
	[price] [float] NOT NULL,
	[speed] [int] NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblFoods] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblCars] ([id], [name], [description], [price], [speed], [status]) VALUES (N'C-000', N'Honda', N'Honda test', 400, 6500, 1)
INSERT [dbo].[tblCars] ([id], [name], [description], [price], [speed], [status]) VALUES (N'C-001', N'Yamaha', N'Yamaha z400', 200, 300, 1)
INSERT [dbo].[tblCars] ([id], [name], [description], [price], [speed], [status]) VALUES (N'C-002', N'Toyota', N'toyota visuz', 1000, 500, 0)
